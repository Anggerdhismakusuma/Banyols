package com.example.dclassicsbooks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class BookListFragment extends Fragment {

    public BookListFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiction, container, false);

        RecyclerView rvBooks = view.findViewById(R.id.rvBooks);
        rvBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        // 1. Bikin Data Buku Fiksi
        List<Book> fictionBooks = new ArrayList<>();
        fictionBooks.add(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", "Rp.140.000,00", R.drawable.harrypotter));
        fictionBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", "Rp.170.000,00", R.drawable.thegreatgatsby));
        fictionBooks.add(new Book("1984", "George Orwell", "Rp.160.000,00", R.drawable.img));
        fictionBooks.add(new Book("The Hobbit", "J.R.R. Tolkien", "Rp.260.000,00", R.drawable.img_1));
        fictionBooks.add(new Book("Pride and Prejudice", "Jane Austen", "Rp78.000,00", R.drawable.img_2));

        // 2. Pasang Adapter
        BookAdapter adapter = new BookAdapter(fictionBooks);
        rvBooks.setAdapter(adapter);

        return view;
    }
}