<template>
    <div class="books fit">

        <div v-for="(book, id) in books" :key="id" class="q-ma-xs ">
            <BookItem :bookname="book.name" :image-url="book.image" :author="book.author"
                :description="book.description" :published-date="book.publishedDate" />
        </div>
    </div>

</template>

<script setup lang="ts">
import axios from 'axios';
import { ref, onMounted } from 'vue';
import BookItem from '../components/BookItem.vue';

const books = ref(['Jimi']);
const token = localStorage.getItem('token')?.toString();


onMounted(() => {
    axios.get('http://localhost:8080/books', { headers: { Authorization: `${token}` } }).then((res) => {
        books.value = res.data;
    })
});
</script>