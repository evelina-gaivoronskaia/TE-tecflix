<template>
  <div class="card" v-on:click="grabMovie" v-bind:to="{name: 'movie-details'}">
    <div class="movie-details" v-for="movie in movies" v-bind:key="movie.movieId">
      <h2 class="title">{{movie.title}}</h2>
      <h3 class="release-date">{{movie.release_date}}</h3>
      <img v-bind:src="movie.movie_img" class="movie_img"/>
      <p class="summary">{{movie.summary}}</p>

    </div>
  </div>
</template>

<script>


export default {
    name: "movie-card",
    data() {
        return { 
          movie: {
            movie_id: "",
            title: "",
            release_date: "",
            summary: "",
            movie_img: "",
          },
          movies: []
        };
    },
}
</script>

<style>

</style>