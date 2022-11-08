package com.sid.sellprocessmicservice.controller;

import com.sid.sellprocessmicservice.feigninterface.FeignPojoExample;
import com.sid.sellprocessmicservice.model.PojoExample;
import com.sid.sellprocessmicservice.repository.PojoRepository;
import lombok.AllArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
public class CustomerController {
    private FeignPojoExample feignClient;
    private PojoRepository pojoRepository;
    @GetMapping(path = "/public")

    public ResponseEntity<List<PojoExample>> getApi(){
        List<PojoExample> list = new ArrayList<>();
        try {


            String res = feignClient.findAll();
            JSONObject jsonObject = new JSONObject( res );
            JSONArray data = jsonObject.getJSONArray( "data" );
            for (int i = 0; i < data.length(); i++) {
                JSONObject l = data.getJSONObject( i );
                list.add( new PojoExample( l.getLong( "id" ), l.getString( "name" ), l.getString( "email" ), l.getString( "gender" )
                        , l.getString( "status" ) ) );

            }

                pojoRepository.saveAll( list );




            return new ResponseEntity<>( list, HttpStatus.OK );
        }catch (Exception e){
            e.printStackTrace();
         return  new ResponseEntity("this was a bad request",HttpStatus.BAD_REQUEST  );
        }
    }
}
