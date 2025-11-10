<template>
  <div>
    <section class="courusel">
      <div class="text-center text-3xl font-bold pt-10 mb-5">{{ props.title }}</div>
      <section class="books">
        <section v-for="book in books" :key="book.id">
          <BookCard :book="book" />
        </section>
      </section>
    </section>
    <section class="courusel-lower-nav">
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
      <span></span>
    </section>
  </div>
</template>

<script setup lang="ts">
import BookCard from '@/components/BookCardView.vue'
import { ref } from 'vue'

const props = defineProps(['title', 'books'])

const books = ref(props.books)
</script>

<style scoped lang="scss">
.books {
  display: flex;
  gap: 20px;
  width: 100%;
  overflow-x: auto;
}
.courusel-lower-nav {
  display: flex;
  justify-content: center;
  gap: 10px;
  margin-top: 30px;
  span {
    width: 10px;
    height: 10px;
    border-radius: 50%;
    background-color: #6366f1;
  }
}
</style>
