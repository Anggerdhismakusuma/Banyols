package com.example.dclassicsbooks;

import android.os.Bundle;
import android.view.*;
import androidx.annotation.*;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.*;

import java.util.*;

public class FictionFragment extends Fragment {

    public FictionFragment() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_fiction, container, false);

        RecyclerView rvBooks = view.findViewById(R.id.rvBooks);
        rvBooks.setLayoutManager(new LinearLayoutManager(getContext()));

        List<Book> fictionBooks = new ArrayList<>();

        fictionBooks.add(new Book(
                "Harry Potter and the Goblet of Fire",
                "J.K. Rowling",
                "Rp.140.000,00",
                "Harry is unexpectedly selected to compete in the Triwizard Tournament, a dangerous magical competition between three wizarding schools. As he faces life-threatening challenges, he begins to uncover a dark plot that signals the return of a powerful enemy.",
                R.drawable.harrypotter
        ));

        fictionBooks.add(new Book(
                "The Great Gatsby",
                "F. Scott Fitzgerald",
                "Rp.170.000,00",
                "Set in the glamorous yet hollow world of 1920s America, the story follows the mysterious Jay Gatsby and his obsession with rekindling a lost love. Beneath the wealth and parties lies a deeper tale of illusion, longing, and tragedy.",
                R.drawable.thegreatgatsby
        ));

        fictionBooks.add(new Book(
                "1984",
                "George Orwell",
                "Rp.160.000,00",
                "In a dystopian society ruled by constant surveillance, Winston Smith secretly rebels against a regime that controls truth and freedom. As he questions reality, he risks everything in a world where independent thought is forbidden.",
                R.drawable.img
        ));

        fictionBooks.add(new Book(
                "The Hobbit",
                "J.R.R. Tolkien",
                "Rp.260.000,00",
                "Bilbo Baggins, a quiet and comfort-loving hobbit, is unexpectedly drawn into an epic quest to reclaim a stolen treasure guarded by a dragon. Along the journey, he discovers courage, friendship, and a side of himself he never knew existed.",
                R.drawable.img_1
        ));

        fictionBooks.add(new Book(
                "Pride and Prejudice",
                "Jane Austen",
                "Rp.100.000,00",
                "Elizabeth Bennet navigates issues of love, reputation, and class in a society driven by expectations. Her evolving relationship with the proud Mr. Darcy reveals how misunderstandings can give way to genuine connection.",
                R.drawable.img_2
        ));

        rvBooks.setAdapter(new BookAdapter(fictionBooks));

        return view;
    }
}
