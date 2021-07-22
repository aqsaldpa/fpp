package com.example.finalproject;

import java.util.ArrayList;

public class BookData {
    private static String[] title = {
            "Catatan Juang",
            "5 CM",
            "1001 Jalan Bisnis Online ",
            "Kenali Agamamu ",
            "Kenali Agamamu ",
            "Cara Dapat Panggilan Kerja ",
            "Cara Dapat Panggilan Kerja ",
            "Cara Dapat Panggilan Kerja ",
    };
    private static String[] category = {
            "Teka-Teki",
            "Adventure",
            "Tips & Trik",
            "Religi ",
            " Inspiratif ",
            " Inspiratif ",
            " Inspiratif ",
            "Tips & Trik"
    };
    private static String[] deskripsi = {
            "Description Book",
            "Description Book",
            "Description Book ",
            " Description Book ",
            " Description Book ",
            " Description Book ",
            " Description Book ",
            "Description Book"
    };
    private static int[] images = {
            R.drawable.catatan_juang,
            R.drawable.five_cm,
            R.drawable.sukses,
            R.drawable.kenali_agamamu,
            R.drawable.kenali_agamamu,
            R.drawable.kenali_agamamu,
            R.drawable.five_cm,
            R.drawable.five_cm
    };
    public static ArrayList<Book> getListData() {
        ArrayList<Book> list = new ArrayList<>();
        for (int position = 0; position < images.length; position++) {
            Book book = new Book();
            book.setTitle(title[position]);
            book.setCategory(category[position]);
            book.setDeskripsi(deskripsi[position]);
            book.setImages(images[position]);
            list.add(book);
        }
        return list;
    }

}
