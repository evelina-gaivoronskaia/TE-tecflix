<template>
  <!-- <div class="card" v-on:click="getMovie" v-bind:to="{name: 'movie-details'}"> -->
  
  <div class="test">
<<<<<<< HEAD
    <div
      v-for="movie in movies"
      v-bind:key="movie.movie_id"
      class="movie-details"
      v-on:click="viewMovieDetails(movie_id)"
    >
      <div id="movieInfo">
        <!-- <h1>HEllo</h1> -->
        <h2 class="title">{{ movie.title }}</h2>
        <img
          v-bind:src="'http://image.tmdb.org/t/p/w185' + movie.poster_path"
          id="movie"
        />
        <h3 class="release-date">{{ movie.release_date }}</h3>
        <p class="summary">{{ movie.overview }}</p>
      </div>

      <!-- <div id="moviePersonalInfo">
          <input
            type="checkbox"
            id="seen"
            v-model="movie.seen"
            class="form-control"
          />
          <label id="seenMovieSection" for="seen"
            >I have seen this movie
          </label>

          <input
            type="checkbox"
            id="favorite"
            v-model="movie.favorite"
            class="form-control"
          />
          <label id="favoriteMovieSection" for="favorite"
            >This is my favorite movie
          </label>

          <button
            id="update"
            class="btn btn-lg btn-primary btn-block"
            type="submit"
          >
            Update movie
          </button>
        </div> -->
=======
    <h1>Movies</h1>
    <div class= "card">
    <div v-for="movie in movies" v-bind:key="movie.title" class="movie-details">
      <!-- <h1>HEllo</h1> -->
      <h2 class="title">{{ movie.title }}</h2>
      <img v-bind:src="'http://image.tmdb.org/t/p/w185' + movie.poster_path" id="movie" />
      <h3 class="release-date">{{ movie.release_date }}</h3>
      <p class="summary">{{ movie.overview }}</p>
>>>>>>> main
    </div>
  </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
  name: "movie-card",
<<<<<<< HEAD
  methods: {
    viewMovieDetails(movie_id) {
      this.$router.push(`/movie/${movie_id}`);
    },
    updateThisMovie() {
      let movieToUpdate = {
        // movie_id: this.movie.movie_id,
        // title: this.movie.title,
        // release_date: this.movie.release_date,
        // overview: this.movie.overview,
        // poster_path: this.movie.poster_path,
        // seen: this.movie.seen,
        // favorite: this.movie.favorite,
      };
      movieToUpdate.movie_id = this.movie.movie_id;
      movieToUpdate.title = this.movie.title;
      MovieService.updateMovie(movieToUpdate, movieToUpdate.movie_id)
        .then((response) => {
          if (response.status === 200) {
            console.log("Updated!");
          }
        })
        .catch((error) => {
          console.log(error.status);
        });
    },
  },
=======
  props: {
    enableAdd:{
      type:Boolean,
      default:false
      
    }
  }, 
  
  
  
  // methods: {
    // getMovies() {
    //     MovieService.getAllMovies().then(response => {
    //        if (response.status === 200) {
    //            this.movies = response.data;
    //        }
    //     });
    // },
    
  // },
>>>>>>> main
  created() {
    // MovieService.getMovie(this.$route.params.movie_id);
    MovieService.getAllMovies().then((response) => {
      // if (response.status === 200) {
      //   this.movies = response.data;
      //   // console.log(this.movies);
      //   // }
      this.movies = response.data;
      console.log(this.movies);
    });
    // console.log(this.movies)
  },
  data() {
    return {
      movie: {
        movie_id: "",
        title: "",
        release_date: "",
        overview: "",
        poster_path: "",
        seen: false,
        favorite: false,
      },
      movies: [],
    };
  },
  // created() {
  //   this.grabMovie();
  // },
};
</script>

<style>
<<<<<<< HEAD
.test {
=======
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap");

h1{
  text-align: center;
  font-size: 150px;
  font-family: "Monoton", sans-serif;
  font-weight: 400;
  margin:5%;
  border: 2px solid rgb(160,99,7);
  background-color: white;
  

}

.card {
>>>>>>> main
  display: flex;
  /* height: 300px;
  width: 200px; */
  /* border: 3px solid red; */
  /* flex-direction: row; */
  flex-wrap: wrap;
  gap: 50px;

  justify-content: space-evenly;
}

.movie-details {
<<<<<<< HEAD
  /* display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 550px 180px;
  grid-template-areas:
    "movieInfo"
    "movieForm"; */
  gap: 10px;
  height: 600px;
  width: 400px;
  color: rgb(236, 229, 226);
  border-block-color: rgb(255, 81, 0);
  text-align: center;
  border: 3px solid rgb(255, 81, 0);
  background-color: #010130;
  opacity: 80%;
  border-radius: 15px 50px;
  padding: auto;
  /* flex-wrap: wrap;  */
=======
   /* display: flex;
   justify-content: space-evenly; */
   height: 550px;
   width: 400px;
   color: rgb(236, 229, 226);
   border-block-color: rgb(255, 81, 0);
   text-align: center;
   border: 3px solid rgb(255, 81, 0);
   background-color: #010130;
   /* opacity: 80%; */
   border-radius: 15px 50px;
   padding: auto;
   /* flex-wrap: wrap;  */
>>>>>>> main

  /*background: white;
    flex-direction: column;
    flex-wrap: wrap;
    padding: 10px, 20px, 10px, 20px;
    border-radius: 15px 50px;
    opacity: 80%;
    width: 500px;
    text-align: center; */
  /* display: flex;
  justify-content: center;
  border: 3px solid red;
  background-color: #010130;
  flex-direction: row;
  flex-wrap: wrap;
  padding: 10px, 20px, 10px, 20px;
  border-radius: 15px 50px;
  opacity: 80%;
  width: 45em;
  text-align: center; */
}
/* #movieInfo {
  grid-area: "movieInfo";
}

#moviePersonalInfo {
  grid-area: "movieForm";
}

#seenMovieSection,
#favoriteMovieSection,
#update {
  margin: 5px 5px 5px 5px;
  font-size: 20px;
} */

#movie {
  /* display: flex; */
  margin: 1px;
  /* align-items: center; */
}
h3 {
  margin: 2px;
}

p.summary {
  /* display: flex;
  flex-direction: column;
  align-content: space-around; */
  color: rgb(245, 238, 238);
  margin: 1em;
}
table {
  margin: 10%;
}
img {
  max-height: 550px;
  max-width: 200px;
}
</style>