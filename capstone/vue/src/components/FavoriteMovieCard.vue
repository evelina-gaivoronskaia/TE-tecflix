<template>
  <!-- <div class="card" v-on:click="getMovie" v-bind:to="{name: 'movie-details'}"> -->

  <div class="test">
    <h1>Movies</h1>
    <div class="card">
      <div
        v-for="movie in movies"
        v-bind:key="movie.title"
        class="movie-details"
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
        <!-- <input
          type="checkbox"
          id="seen"
          v-model="movie.seen"
          class="form-control"
        />
        <label id="seenMovieSection" for="seen">I have seen this movie </label> -->
        <div id="movieFrom">
          <div id="preference">
            <input
              type="checkbox"
              id="favorite"
              v-model="movie.favorite"
              class="form-control"
              name="isFavorited"
              value="movie.favorite"
            />

            <label id="favoriteMovieSection" for="favorite"
              >This is my favorite movie
            </label>
          </div>
          <button
            id="update"
            class="btn btn-lg btn-primary btn-block"
            v-on:click="updateThisMovie(movie)"
          >
            Update movie
          </button>
        </div>
      </div>
    </div>
  </div>
</template>


<script>
import MovieService from "../services/MovieService";

export default {
  name: "movie-card",
  methods: {
    updateThisMovie(movie) {
      MovieService.updateMovie(movie, movie.id)
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
  props: {
    enableAdd: {
      type: Boolean,
      default: false,
    },
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
  created() {
    // MovieService.getMovie(this.$route.params.movie_id);
    MovieService.getFavoriteMovies().then((response) => {
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
        // seen: false,
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
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap");

h1 {
  text-align: center;
  font-size: 150px;
  font-family: "Monoton", sans-serif;
  font-weight: 400;
  margin: 5%;
  border: 2px solid rgb(160, 99, 7);
  background-color: white;
}

.card {
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
  display: grid;
  grid-template-columns: 1fr;
  grid-template-rows: 700px 150px;
  grid-template-areas:
    "movieInfo"
    "movieForm";
  gap: 20px;
  height: 850px;
  width: 300px;
  color: rgb(236, 229, 226);
  border-block-color: rgb(255, 81, 0);
  text-align: center;
  border: 3px solid rgb(255, 81, 0);
  background-color: #010130;
  opacity: 100%;
  border-radius: 15px 50px;
  padding: auto;
}

#movieInfo {
  grid-area: "movieInfo";
}

#movieForm {
  grid-area: "movieForm";
  /* margin: 5px 5px 5px 5px;
  font-size: 20px; */
}

#preference {
  display: flex;
  justify-content: center;
}

#favorite {
  width: 10%;
  margin: 5px 15px 5px;
}

#favoriteMovieSection {
  text-align: left;
}

#update {
  display: block;
  justify-self: center;
  margin: 5px 80px 5px 80px;
  width: 0.9fr;
  height: 30px;
}

/* #favoriteMovieSection,
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