<template>
  <div class="browse">
    <!-- <link
      href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
      rel="stylesheet"
    /> -->
      <movie-list />
  </div>
</template>

<script>
import MovieList from '@/components/MovieList';
export default {
    name: 'browse-movies',
    components: {
        MovieList
    }
}
</script>

<style scoped>
/* @import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap"); */

.browse {
  display:flex;
  justify-content: space-evenly;
  flex-wrap: wrap;
  /* background: blueviolet; */
}
</style>