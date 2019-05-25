package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface{
        private TableInterface table;

        public TableInterfaceWrapper(TableInterface table){
            this.table = table;
        }

        public void setModel(List rows){
            int count = rows.size();
            System.out.println(count);
            table.setModel(rows);
        }

        public void setHeaderText(String newHeaderText){
            table.setHeaderText(newHeaderText);
        }

        public String getHeaderText(){
            return table.getHeaderText().toUpperCase();
        }
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}