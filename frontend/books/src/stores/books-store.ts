import { defineStore } from 'pinia';

export const useBooksStore = defineStore('books', {
  state: () => ({
    books: [{}],
  }),
  getters: {
    getBooks: (state) => state.books,
  },
  actions: {
    fetchBooks() {
      const token = localStorage.getItem('token')?.toString();

      fetch('http://localhost:8080/user/books', {
        headers: { Authorization: `${token}` },
      })
        .then((res) => res.json())
        .then((data) => {
          this.books = data;
        });
    },
  },
});
