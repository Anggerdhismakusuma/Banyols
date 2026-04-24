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

public class NonFictionFragment extends Fragment {

    public NonFictionFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fiction, container, false);

        RecyclerView rvBooks = view.findViewById(R.id.rvBooks);
        rvBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Book> nonFictionBooks = new ArrayList<>();
        nonFictionBooks.add(new Book("Sapiens", "Yuval Noah Harari", "Rp.150.000,00", R.drawable.img_3));
        nonFictionBooks.add(new Book("Atomic Habits", "James Clear", "Rp.120.000,00", R.drawable.img_4));
        nonFictionBooks.add(new Book("Rich Dad Poor Dad", "Robert Kiyosaki", "Rp.100.000,00", R.drawable.img_5));
        nonFictionBooks.add(new Book("Educated", "Tara Westover", "Rp.190.000,00", R.drawable.img_6));
        nonFictionBooks.add(new Book("Thinking, Fast and Slow", "Daniel Kahneman", "Rp.130.000,00", R.drawable.img_7));

        // Pasang Adapter
        BookAdapter adapter = new BookAdapter(nonFictionBooks);
        rvBooks.setAdapter(adapter);

        return view;
    }
}