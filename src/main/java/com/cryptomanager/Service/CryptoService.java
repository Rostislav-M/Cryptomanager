package com.cryptomanager.Service;

import com.cryptomanager.Model.Crypto;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

@Service
public class CryptoService {

    private final ArrayList<Crypto> listOfCryptoPortfolio;

    public CryptoService(ArrayList<Crypto>listOfCryptoPortfolio){
        this.listOfCryptoPortfolio= listOfCryptoPortfolio;
    }


    public void addCrypto(Crypto crypto){
        listOfCryptoPortfolio.add(crypto);
    }

    public ArrayList<Crypto> getListOfCryptoPortfolio(){
        return listOfCryptoPortfolio;
    }

    public ArrayList<Crypto> getSortedByPriceListOfCryptoPortfolio(){
        listOfCryptoPortfolio.sort(Comparator.comparing(Crypto::getPrice));
        return listOfCryptoPortfolio;
        }

    public ArrayList<Crypto> getSortedByNameListOfCryptoPortfolio(){
        listOfCryptoPortfolio.sort(Comparator.comparing(Crypto::getName));
        return listOfCryptoPortfolio;
    }

    public ArrayList<Crypto> getSortedByQuantityListOfCryptoPortfolio(){
        listOfCryptoPortfolio.sort(Comparator.comparing(Crypto::getQuantity));
        return listOfCryptoPortfolio;
    }

    public Crypto getCryptoById (int id){
        for (Crypto crypto: listOfCryptoPortfolio){
            if(crypto.getId()== id){
                return crypto;
            }
        }
        return null;
    }
    public Crypto updateCryptoById(int id, Crypto cryptoToUpdate) {
        for (Crypto crypto: listOfCryptoPortfolio){
            if(crypto.getId()== id){
                crypto.setName(cryptoToUpdate.getName());
                crypto.setSymbol(cryptoToUpdate.getSymbol());
                crypto.setPrice(cryptoToUpdate.getPrice());
                crypto.setQuantity(cryptoToUpdate.getQuantity());
                return crypto;
            }
        }
        return null;
    }
    public BigDecimal calculatePortfolioTotal() {
        BigDecimal totalValue= BigDecimal.ZERO;
        if(listOfCryptoPortfolio == null || listOfCryptoPortfolio.isEmpty()){
           return null;
        }
        for(Crypto crypto: listOfCryptoPortfolio){
            if(crypto.getQuantity()>0){  // pro kryptomeny pouze s quantity > 0
            BigDecimal price = BigDecimal.valueOf(crypto.getPrice());
            BigDecimal quantity = BigDecimal.valueOf(crypto.getQuantity());
            totalValue= totalValue.add(price.multiply(quantity));
            }
        }return totalValue;
    }

}
