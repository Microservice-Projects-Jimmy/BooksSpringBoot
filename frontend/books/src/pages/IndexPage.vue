<template>
  <q-page class="home-page">
    <div>
      <section class="intro">
        <span>Buy and sell your books </span>
        <span>for the best prices</span>
      </section>
      <section class="sub-info">
        Find and read more yuor’ll love, and keep track of the books you want to
        read. Be part of the word’s largeest community of book lovers on
        Goodreads.
      </section>
    </div>
  </q-page>
</template>

<script setup lang="ts"></script>

<style scoped lang="scss">
.home-page {
  --font-size: 18px;
  --font-weight: 500;
  color: #000000;
  padding: 50px 150px;
}

.sub-info {
  max-width: 890px;
  font-size: calc(var(--font-size) + 7px);
}

.intro {
  max-width: 770px;
  font-size: calc(var(--font-size) * 4);
  font-weight: calc(var(--font-weight) + 300);
  & span:nth-child(2) {
    color: #6366f1;
  }
}
</style>
