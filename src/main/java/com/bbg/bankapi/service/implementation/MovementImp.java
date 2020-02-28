package com.bbg.bankapi.service.implementation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.bbg.bankapi.dto.AccountDto;
import com.bbg.bankapi.dto.MovementDto;
import com.bbg.bankapi.model.Movement;
import com.bbg.bankapi.repositories.MovementRepo;
import com.bbg.bankapi.repositories.AccountRepo;
import com.bbg.bankapi.service.MovementService;

import org.springframework.stereotype.Service;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;



@Service
public class MovementImp extends MovementService{

    private MovementRepo movementRepo;
    private AccountRepo accountRepo;

    
    // Currency layer
    public  final String ACCESS_KEY = "936effdd5bdda5e1ed275b7212e30edd";
    public  final String BASE_URL = "http://api.currencylayer.com/";
    public  final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    CloseableHttpClient httpClient = HttpClients.createDefault();
    
    public MovementImp(MovementRepo movementRepo, AccountRepo accountRepo){
        this.movementRepo = movementRepo;
        this.accountRepo = accountRepo;
    }

    @Override
    public List<Movement> find() {
       List<MovementDto> dtos = movementRepo.findAll();
       List<Movement> models = new ArrayList<Movement>();
        
       for (MovementDto dto : dtos) {
           models.add(new Movement(dto));
       }

       return models;
    }
    
    @Override
    public List<Movement> findByDestination(String destination) {
        List<MovementDto> dtos = movementRepo.findByDestinationOrOriginEquals(destination, destination);
        List<Movement> models = new ArrayList<Movement>();

        for (MovementDto movementDto : dtos) {
            Movement model = new Movement(movementDto);
            models.add(model);
        }
        
        return models;
    }

    @Override
    public Movement findById(int id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void save(Movement movement) {
        movementRepo.save(new MovementDto(movement));
        AccountDto origin = accountRepo.findByAccountNumber(movement.getOrigin());
        AccountDto destination = accountRepo.findByAccountNumber(movement.getDestination());
        int amount = movement.getAmount();
      
        if(movement.getType().equalsIgnoreCase("transfer")){
            //check for currency conversion
            if(origin.getCurrency().equalsIgnoreCase(destination.getCurrency()) != true){
                //Exchange reate is needed
            
                // The following line initializes the HttpGet Object with the URL in order to send a request
                HttpGet get = new HttpGet(BASE_URL + ENDPOINT + "?access_key=" + ACCESS_KEY + "&currencies=USD,CRC&format=1");

                try {
                    CloseableHttpResponse response =  httpClient.execute(get);
                    HttpEntity entity = response.getEntity();
        
                    // the following line converts the JSON Response to an equivalent Java Object
                    JSONObject exchangeRates = new JSONObject(EntityUtils.toString(entity));
                   
                    //get rate
                    int rate = (int)exchangeRates.getJSONObject("quotes").getDouble("USDCRC");
                    System.out.println("1 " + exchangeRates.getString("source") + " in CRC : " + exchangeRates.getJSONObject("quotes").getDouble("USDCRC")); 


                    if(origin.getCurrency().equals("USD") && destination.getCurrency().equals("CRC")){
                        //Update origin balance before conversion
                        origin.setBalance(origin.getBalance() - amount);
                        
                        //Convert to CRC
                       amount = amount * rate;
                       //Update destination balance
                       destination.setBalance(destination.getBalance() + amount);

    
                    }else if( origin.getCurrency().equals("CRC") && destination.getCurrency().equals("USD")){
                        //Convert to USD
                        int fakeAmount = amount;
                        if(movement.getCurrency().equals("USD")){
                            fakeAmount = amount * rate;
                        }else{
                            amount = amount / rate;
                        }
                        //Update destination balance
                        destination.setBalance(destination.getBalance() + amount);

                        //Update origin balance after conversion
                        
                        origin.setBalance(origin.getBalance() - fakeAmount);
                    }
    
                }catch (ClientProtocolException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }   
    
            }
            else{
                origin.setBalance(origin.getBalance() - amount);
                destination.setBalance(destination.getBalance() + amount);
            }
            ////update balance
            accountRepo.save(destination);
        }else{
            //Case of payments for services
            origin.setBalance(origin.getBalance() - amount);
          
        }
            
        accountRepo.save(origin);
        
        
    }

    @Override
    public void delete(Movement movement) {
        // TODO Auto-generated method stub

    }


}