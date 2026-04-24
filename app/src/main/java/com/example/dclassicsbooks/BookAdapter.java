package com.example.dclassicsbooks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder> {

    private List<Book> bookList;

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @NonNull
    @Override
    public BookViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book, parent, false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BookViewHolder holder, int position) {
        Book book = bookList.get(position);
        holder.title.setText(book.title);
        holder.author.setText(book.author);
        holder.price.setText(book.price);
        // Kalau lu belum punya foto, biarin dibaris bawah ini error atau komenin dulu
         holder.cover.setImageResource(book.imageResId);
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    static class BookViewHolder extends RecyclerView.ViewHolder {
        TextView title, author, price;
        ImageView cover;

        public BookViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.txtBookTitle);
            author = itemView.findViewById(R.id.txtBookAuthor);
            price = itemView.findViewById(R.id.txtBookPrice);
            cover = itemView.findViewById(R.id.imgBookCover);
        }
    }
}