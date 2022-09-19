<template>
    <div>
        <span class="text-h4 q-ml-xl">My Books</span>
        <div class="q-ma-lg text-center">
            <q-btn to="/library" color="primary">Back to Library</q-btn>
        </div>
        <div class="books fit">

            <div v-for="(book, id) in books" :key="id" class="q-ma-xs ">
                <BookItem :id="book.id" :bookname="book.name" :image-url="book.image" :author="book.author"
                    :description="book.description" :published-date="book.publishedDate" :my-book="true" />
            </div>
        </div>
        <div class="q-mt-xl text-center">
            <q-btn color="primary" @click="returnAllBooks()">Return all</q-btn>
        </div>

    </div>

</template>

<script setup lang="ts">
import { useBooksStore } from 'src/stores/books-store';
import { onMounted } from 'vue';
import { storeToRefs } from 'pinia';
import BookItem from '../components/BookItem.vue';
import axios from 'axios';

const store = useBooksStore();
const { books } = storeToRefs(store);
const token = localStorage.getItem('token')?.toString();


function returnAllBooks() {
    axios.put('http://localhost:8080/books/return-all', {}, { headers: { Authorization: `${token}` } }).then((res) => {
        store.fetchBooks();
    })
}

onMounted(() => {
    store.fetchBooks();
});
</script>