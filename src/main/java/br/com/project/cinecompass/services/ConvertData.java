package br.com.project.cinecompass.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class ConvertData implements IConvertData {

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T getDados(String json, Class<T> classe) {
        // TODO Auto-generated method stub
        try {
            return mapper.readValue(json, classe);
        } catch (JsonProcessingException e) {
            throw new RuntimeException();
        }
      
       
    }
    
   
}
