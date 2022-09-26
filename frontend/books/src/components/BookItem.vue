<template>
    <q-card class="my-card text-white book-card" style="background: radial-gradient(circle, #35a2ff 0%, #014a88 100%)">
        <div class="text-center text-h5">{{bookname}}</div>
        <q-card-section class="text-center">
            <q-img :src="imageUrl" width="200px" height="300px"></q-img>
            <div>Author: {{author}}</div>
            <div> {{description}}</div>
            <div>{{publishedDate}}</div>
        </q-card-section>
        <q-card-actions align="center" class="absolute-bottom q-px-lg">
            <q-btn v-if="!myBook" no-caps color="primary" class="full-width" @click="borrowBook(id)">Borrow</q-btn>
            <q-btn v-else no-caps color="primary" class="full-width" @click="returnBook(id)">
                Return</q-btn>
        </q-card-actions>
    </q-card>
</template>
<script setup lang="ts">
import axios from 'axios';
import { useBooksStore } from 'src/stores/books-store';
import { useQuasar } from 'quasar';


const $q = useQuasar();
const token = localStorage.getItem('token')?.toString();
const store = useBooksStore();

function showNotif(message: string, type: string) {
    $q.notify({
        message: message,
        type: type
    })
}

function borrowBook(id: number) {
    axios.put('http://localhost:8080/books/' + id + '/borrow', {}, { headers: { Authorization: `${token}` } }).then((res) => {
        showNotif('Book borrowed!', 'positive')
    }).catch(function (error) {
        if (error.response) {
            showNotif(error.response.data.message, 'negative');
        }
    });
}

function returnBook(id: number) {
    axios.put('http://localhost:8080/books/' + id + '/return', {}, { headers: { Authorization: `${token}` } }).then((res) => {
        store.fetchBooks();
    })

}

defineProps<{
    id: number
    bookname: string,
    imageUrl: string,
    author: string,
    description: string,
    publishedDate: string
    myBook: {
        type: boolean,
        default: false,
    }
}>()

</script>