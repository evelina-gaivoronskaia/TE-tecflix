<template>
  <!-- <div class="card" v-on:click="getMovie" v-bind:to="{name: 'movie-details'}"> -->
  <div class="test">
    <div v-for="movie in movies" v-bind:key="movie.title" class="movie-details">
      <!-- <h1>HEllo</h1> -->
      <h2 class="title">{{ movie.title }}</h2>
      <img v-bind:src="'http://image.tmdb.org/t/p/w185' + movie.poster_path" id="movie" />
      <h3 class="release-date">{{ movie.release_date }}</h3>
      <p class="summary">{{ movie.overview }}</p>
    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
  name: "movie-card",
  // props: {
  //   movie: Object,
  //   enableAdd:{
  //     type:Boolean,
  //     default:false
      
    
  
  
  
  // methods: {
    // getMovies() {
    //     MovieService.getAllMovies().then(response => {
    //        if (response.status === 200) {
    //            this.movies = response.data;
    //        }
    //     });
    // },
    
  // },
  created() {
      // MovieService.getMovie(this.$route.params.movie_id);
      MovieService.getAllMovies().then(response => {
        // if (response.status === 200) {
        //   this.movies = response.data;
        //   // console.log(this.movies);
      //   // }
      this.movies = response.data
      console.log(this.movies)
      
      })
// console.log(this.movies)
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
  // created() {
  //   this.grabMovie();
  // },
};
</script>

<style>

.test {
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
   /* display: flex;
   justify-content: space-evenly; */
   height: 550px;
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