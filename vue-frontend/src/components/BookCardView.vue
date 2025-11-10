<template>
  <div class="book-card">
    <section class="book-image">
      <img src="@/assets/images/book.png" alt="Example Book" />
    </section>
    <section class="book-details">
      <div class="book-title">{{ bookTitle }}</div>
      <div class="book-author">
        {{ bookAuthor }}
        <section class="book-rate flex">
          <span v-for="star in 5" :key="star" class="star-wrapper">
            <!-- Gray background star -->
            <svg
              width="24"
              height="23"
              viewBox="0 0 24 23"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
              class="star-bg"
            >
              <path
                d="M11.7118 0L15.7942 6.81934L23.4237 8.6664L18.3173 14.7281L18.9501 22.6889L11.7118 19.6159L4.47347 22.6889L5.10631 14.7281L-6.48499e-05 8.6664L7.62938 6.81934L11.7118 0Z"
                fill="#C7D2FE"
              />
            </svg>
            <!-- Green foreground star (clipped) -->
            <svg
              width="24"
              height="23"
              viewBox="0 0 24 23"
              fill="none"
              xmlns="http://www.w3.org/2000/svg"
              class="star-fg"
              :style="{ clipPath: `inset(0 ${100 - getStarFillPercentage(star)}% 0 0)` }"
            >
              <path
                d="M11.7118 0L15.7942 6.81934L23.4237 8.6664L18.3173 14.7281L18.9501 22.6889L11.7118 19.6159L4.47347 22.6889L5.10631 14.7281L-6.48499e-05 8.6664L7.62938 6.81934L11.7118 0Z"
                fill="#84CC16"
              />
            </svg>
          </span>
        </section>
      </div>
      <p class="book-description">{{ bookDescription }}</p>
    </section>
    <button class="buy-button">
      <span>
        <svg
          width="30"
          height="24"
          viewBox="0 0 30 24"
          fill="none"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="M14.875 22.9006C12.7657 21.6828 10.3731 21.0417 7.9375 21.0417C5.50193 21.0417 3.10927 21.6828 1 22.9006V2.8589C3.10927 1.64111 5.50193 1 7.9375 1C10.3731 1 12.7657 1.64111 14.875 2.8589M14.875 22.9006C16.9843 21.6828 19.3769 21.0417 21.8125 21.0417C24.2481 21.0417 26.6407 21.6828 28.75 22.9006V2.8589C26.6407 1.64111 24.2481 1 21.8125 1C19.3769 1 16.9843 1.64111 14.875 2.8589M14.875 22.9006V2.8589"
            stroke="white"
            stroke-width="2"
            stroke-linecap="round"
            stroke-linejoin="round"
          />
        </svg>
      </span>
      Buy Now
    </button>
  </div>
</template>

<script setup lang="ts">
import { computed } from 'vue'

const props = defineProps({
  book: {
    type: Object,
    required: true,
  },
})

const bookTitle = computed(() => props.book.book_title)
const bookAuthor = computed(() => props.book.book_author)
const bookDescription = computed(() => props.book.book_description)
const bookRating = computed(() => props.book.book_ratings)

const getStarFillPercentage = (starIndex: number): number => {
  const rating = bookRating.value || 0

  if (rating >= starIndex) {
    return 100
  } else if (rating > starIndex - 1) {
    return (rating - (starIndex - 1)) * 100
  } else {
    return 0
  }
}
</script>

<style scoped lang="scss">
.book-card {
  min-width: 362px;
  height: 593px;
  background-color: #eef2ff;
  padding-block: 30px;
  border-radius: 1rem;
  display: flex;
  justify-content: start;
  align-items: center;
  flex-direction: column;
}
.book-details {
  max-width: 310px;
  padding-left: 8px;
}
.book-image {
  min-width: 310px;
  height: 300px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #d9d9d9;
  border-radius: 1rem;
  img {
    max-width: 200px;
    max-height: 255px;
  }
}
.buy-button {
  background-color: #18181b;
  color: white;
  min-width: 310px;
  height: 50px;
  border-radius: 12px;
  margin-top: auto;
  display: flex;
  justify-content: center;
  align-items: center;
  gap: 25px;
  font-size: 20px;
  font-weight: 700;
  &:hover {
    background-color: #9ca5f9;
  }
}
.book {
  &-title {
    font-size: 21px;
    font-weight: 700;
    margin-top: 20px;
  }
  &-author {
    display: flex;
    gap: 20px;
    margin-block: 10px;
    font-size: 18px;
    color: #9ca5f9;
    font-weight: 700;
  }
  &-description {
    color: #4f514c;
    font-weight: 700;
  }
}
.book-rate {
  display: flex;
  gap: 4px; // Add some spacing between stars

  span.star-wrapper {
    position: relative;
    display: inline-block; // This is crucial!
    width: 24px;
    height: 23px;

    & > svg {
      position: absolute;
      top: 0;
      left: 0;
    }
  }
}
</style>
