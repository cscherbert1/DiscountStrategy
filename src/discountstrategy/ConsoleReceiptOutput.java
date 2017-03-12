/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package discountstrategy;

/**
 *
 * @author cscherbert1
 */
public class ConsoleReceiptOutput implements OutputStrategy {

    @Override
    public void generateReceipt(String receiptData) {
        System.out.println(receiptData);
    }
    
}
