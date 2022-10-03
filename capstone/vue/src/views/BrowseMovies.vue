<template>
<<<<<<< HEAD
  <div class="browse">
    <!-- <link
      href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
      rel="stylesheet"
    /> -->
      <movie-list />
=======
  <div>
      <movie-card />
>>>>>>> main
  </div>
</template>

<script>
// import MovieList from '@/components/MovieList';
import MovieCard from '../components/MovieCard.vue';
export default {
    name: 'browse-movies',
    components: {
        // MovieList,
        MovieCard
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