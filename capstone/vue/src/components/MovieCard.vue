<template>
  <div class="card" v-on:click="getMovie" v-bind:to="{name: 'movie-details'}">
    <div class="movie-details" v-for="movie in movies" v-bind:key="movie.movieId">
      <h2 class="title">{{movie.title}}</h2>
      <h3 class="release-date">{{movie.release_date}}</h3>
      <img v-bind:src="movie.movie_img" class="movie_img"/>
      <p class="summary">{{movie.summary}}</p>

    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
    name: 'movie-card',
    methods: {
        getMovies() {
            MovieService.getAllMovies().then(response => {
               if (response.status === 200) {
                   this.movies = response.data;
               }
            });
        },
        grabMovie() {
            MovieService.getMovies(this.$route.params.movie_id);
        },
    },
    data() {
        return {
            movie: {
              movie_id: "",
              title: "",
              release_date: "",
              summary: "",
              movie_img: "",
            },
            movies: [],
        };
    },
    created() {
        this.getMovies()
    }
}
</script>

<style>
.movie-card {
    /* display: flex;
    justify-content: center;
    background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 500px;
    text-align: center; */
    display: flex;
    justify-content: center;
    background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 45em;
    text-align: center;
    
}
#movie-display {
    display: flex;
    margin: 20px;
    align-items: center;
}
h4 {
    margin: 10%;
}
.movie-info {
    display: flex;
    flex-direction: column;
    align-content: space-around;
}
table {
    margin: 10%;
}
/* img {
    max-height: 600px;
} */
</style>