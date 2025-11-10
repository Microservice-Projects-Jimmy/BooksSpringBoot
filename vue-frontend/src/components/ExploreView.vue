<template>
  <div class="explore-component flex justify-between">
    <section>
      <span class="books-collection"> </span>
    </section>
    <section class="max-w-[613px] flex flex-col">
      <div>
        <span class="block subtitle">Find Your Favorite</span>
        <span class="block subtitle">Book Here!</span>
        <p>
          Lorem ipsum dolor sit, amet consectetur adipisicing elit. Quo ad non reprehenderit.
          Reiciendis illo iusto incidunt distinctio exercitationem officiis dicta dolores dolorem
          ea! Non saepe, voluptatum cupiditate beatae in dolore!
        </p>
      </div>
      <div class="flex justify-between stats">
        <span>
          <div>500+</div>
          <div>Book Listing</div>
        </span>
        <span>
          <div>850+</div>
          <div>Register User</div>
        </span>
        <span>
          <div>1100+</div>
          <div>Books Sold</div>
        </span>
      </div>
      <button>Explore Now</button>
    </section>
  </div>
</template>
<script setup lang="ts"></script>

<style scoped lang="scss">
.explore-component {
  --font-size: 26px;
}
.books-collection {
  display: flex;
  min-width: 626px;
  min-height: 734px;
  background-color: #fcb80f;
  border-radius: 16px;
}
.subtitle {
  font-size: calc(var(--font-size) * 2);
  font-weight: 800;
  &:last-of-type {
    color: #6366f1;
  }
}
p {
  font-size: var(--font-size);
}
.stats > span > div:first-child {
  font-size: calc(var(--font-size) * 1.5);
  font-weight: 800;
}
.stats > span > div:last-child {
  font-size: var(--font-size);
  font-weight: 500;
}

button {
  margin-top: auto;
  padding: 10px 20px;
  font-size: var(--font-size);
  background-color: #6366f1;
  color: white;
  border: none;
  border-radius: 8px;
  cursor: pointer;
  margin-top: auto;
  max-width: 200px;
}

button:hover {
  background-color: #4f46e5;
}
</style>
