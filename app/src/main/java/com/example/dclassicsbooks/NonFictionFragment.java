package com.example.dclassicsbooks;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import java.util.*;

public class NonFictionFragment extends Fragment {

    public NonFictionFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fiction, container, false);

        RecyclerView rvBooks = view.findViewById(R.id.rvBooks);
        rvBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Book> nonFictionBooks = new ArrayList<>();

        nonFictionBooks.add(new Book(
                "Sapiens",
                "Yuval Noah Harari",
                "Rp.150.000,00",
                "This book explores the history of humankind, from early hunter-gatherers to modern societies. It examines how culture, beliefs, and innovations shaped the world we live in today.",
                R.drawable.img_3
        ));

        nonFictionBooks.add(new Book(
                "Atomic Habits",
                "James Clear",
                "Rp.120.000,00",
                "A practical and insightful guide that shows how small habits can lead to remarkable results. It focuses on building positive routines and breaking negative ones through consistent and manageable changes.",
                R.drawable.img_4
        ));

        nonFictionBooks.add(new Book(
                "Rich Dad Poor Dad",
                "Robert Kiyosaki",
                "Rp.100.000,00",
                "Through the story of two father figures with different views on money, the book teaches essential lessons about financial independence, investing, and the mindset needed to build wealth.",
                R.drawable.img_5
        ));

        nonFictionBooks.add(new Book(
                "Educated",
                "Tara Westover",
                "Rp.190.000,00",
                "A powerful memoir about a woman who grows up in a strict and isolated environment without formal schooling. Her journey toward education becomes a path to self-discovery and freedom.",
                R.drawable.img_6
        ));

        nonFictionBooks.add(new Book(
                "Thinking, Fast and Slow",
                "Daniel Kahneman",
                "Rp.130.000,00",
                "This book reveals how our minds work through two systems: one fast and intuitive, the other slow and logical. It explains how these systems influence our decisions, often without us realizing it.",
                R.drawable.img_7
        ));

        BookAdapter adapter = new BookAdapter(nonFictionBooks);
        rvBooks.setAdapter(adapter);

        return view;
    }
}
