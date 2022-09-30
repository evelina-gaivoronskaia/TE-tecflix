<template>
  <div>
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
      rel="stylesheet"
    />
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
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap");

div {
    color: rgb(6, 111, 202);
}
</style>