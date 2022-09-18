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
            <q-btn no-caps color="primary" class="full-width">Borrow</q-btn>
        </q-card-actions>
    </q-card>
</template>
<script setup lang="ts">

defineProps<{
    bookname: string,
    imageUrl: string,
    author: string,
    description: string,
    publishedDate: string
}>()

</script>