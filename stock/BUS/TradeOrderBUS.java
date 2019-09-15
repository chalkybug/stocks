/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stock.BUS;

import java.util.Comparator;
import java.util.PriorityQueue;
import stock.DTO.TradeOrder;

/**
 *
 * @author luong
 */
public class TradeOrderBUS {

    private PriorityQueue<TradeOrder> dsMua = new PriorityQueue<TradeOrder>(new Comparator<TradeOrder>() {

        @Override
        public int compare(TradeOrder o1, TradeOrder o2) {
            return -(o1.getPrices() - o2.getPrices());
        }
    });
    private PriorityQueue<TradeOrder> dsBan = new PriorityQueue<TradeOrder>(new Comparator<TradeOrder>() {

        @Override
        public int compare(TradeOrder o1, TradeOrder o2) {
            return (o2.getPrices() - o1.getPrices());
        }
    });
    private String message = "";

    public String khopLenh() {
        if (!dsBan.isEmpty() && !dsMua.isEmpty()) {

            TradeOrder NgMua = dsMua.peek();
            TradeOrder NgBan = dsBan.peek();
            if (NgMua.getPrices() >= NgBan.getPrices()) {
                if (NgMua.getQuantity() >= NgBan.getQuantity()) {
                    NgMua.setQuantity(NgMua.getQuantity() - NgBan.getQuantity());
                    if (NgMua.getQuantity() == 0) {
                        dsMua.poll();
                    }
                    message += NgMua.getName() + " da mua cua " + NgBan.getName() + " " + NgBan.getQuantity() + "\n";
                    dsBan.poll();

                } else {
                    NgBan.setQuantity(NgBan.getQuantity() - NgMua.getQuantity());
                    if (NgBan.getQuantity() == 0) {
                        dsBan.poll();
                    }
                    message += NgMua.getName() + " da mua cua " + NgBan.getName() + " " + NgMua.getQuantity() + "\n";
                    dsMua.poll();
                }
                khopLenh();
            }

            if (NgMua.getPrices() < NgBan.getPrices()) {
                return message;
            }
        } else {

            return message;
        }
        return message;
    }

}
