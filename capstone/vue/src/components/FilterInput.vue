<template>
  <div id="movieFilter">
    <form id="searchForm">
      <div class="titleSearch">
        <label id="titleSearchLabel" for="titleLabel">Movie Title: </label>
        <input
          type="text"
          id="movieTitle"
          class="form-control"
          v-model="filters.title"
          placeholder="Search movie title"
        />
      </div>
      <div class="fromElement">
        <drop-down-menu id="dropDownMenu" menu-title="">
          <section class="option">
            <input type="checkbox" id="action" value="28" v-model="genreIds" />
            <label for="action">Action</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="adventure"
              value="12"
              v-model="genreIds"
            />
            <label for="adventure">Adventure</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="animation"
              value="16"
              v-model="genreIds"
            />
            <label for="animation">Animation</label>
          </section>
          <section class="option">
            <input type="checkbox" id="comedy" value="35" v-model="genreIds" />
            <label for="comedy">Comedy</label>
          </section>
          <section class="option">
            <input type="checkbox" id="crime" value="80" v-model="genreIds" />
            <label for="crime">Crime</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="documentary"
              value="99"
              v-model="genreIds"
            />
            <label for="documentary">Documentary</label>
          </section>
          <section class="option">
            <input type="checkbox" id="drama" value="18" v-model="genreIds" />
            <label for="drama">Drama</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="family"
              value="10751"
              v-model="genreIds"
            />
            <label for="family">Family</label>
          </section>
          <section class="option">
            <input type="checkbox" id="fantasy" value="14" v-model="genreIds" />
            <label for="fantasy">Fantasy</label>
          </section>
          <section class="option">
            <input type="checkbox" id="history" value="36" v-model="genreIds" />
            <label for="history">History</label>
          </section>
          <section class="option">
            <input type="checkbox" id="horror" value="27" v-model="genreIds" />
            <label for="horror">Horror</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="music"
              value="10402"
              v-model="genreIds"
            />
            <label for="music">Music</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="mystery"
              value="9648"
              v-model="genreIds"
            />
            <label for="mystery">Mystery</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="romance"
              value="10749"
              v-model="genreIds"
            />
            <label for="romance">Romance</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="scienceFiction"
              value="878"
              v-model="genreIds"
            />
            <label for="scienceFiction">Science Fiction</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="TVmovie"
              value="10770"
              v-model="genreIds"
            />
            <label for="TVmovie">TV Movie</label>
          </section>
          <section class="option">
            <input
              type="checkbox"
              id="thriller"
              value="53"
              v-model="genreIds"
            />
            <label for="thriller">Thriller</label>
          </section>
          <section class="option">
            <input type="checkbox" id="war" value="10752" v-model="genreIds" />
            <label for="war">War</label>
          </section>
          <section class="option">
            <input type="checkbox" id="western" value="37" v-model="genreIds" />
            <label for="western">Western</label>
          </section>
        </drop-down-menu>
      </div>
    </form>
    <button
      id="submit"
      input="submit"
      type="submit"
      v-on:click.prevent="filterMovies"
    >
      Submit
    </button>
  </div>
</template>

<script>
import DropDownMenu from "../components/DropDownMenu.vue";
import MovieService from "../services/MovieService";

export default {
  name: "search",
  components: {
    DropDownMenu,
  },
  data() {
    return {
      filters: {
        title: "",
        genreIds: [],
      },
      genre_name: "",
    };
  },
  methods: {
    filterMovies() {
      MovieService.getMoviesWithFilters(this.filters).then((response) => {
        this.$store.commit("SET_MOVIES", response.data);
      });
    },
    selectGenre(event) {
      if (event.target.id) {
        this.genreIds.push(parseInt(event.target.id));
      }
    },
  },
};
</script>

<style scoped>
#movieFilter {
  display: block;
  background-color: #010130;
  min-height: 100px;
  width: 400px;
  margin: 0 50em 0 50em;
}

#searchFrom {
  display: grid;
  grid-template-areas: "titleSearchALabel titleInput genre submit";
  grid-template-columns: 1fr 1fr 1fr 1fr;
  color: rgb(236, 229, 226);
  border-block-color: rgb(255, 81, 0);
  text-align: center;
  border: 3px solid rgb(255, 81, 0);
  background-color: #010130;
  opacity: 100%;
  border-radius: 15px 50px;
  padding: auto;
}

#titleSearchLabel {
  grid-area: "titleSearchLabel";
}

#movieTitle {
  grid-area: "titleInput";
}

#dropDownMenu {
  grid-area: "genre";
}

#submit {
  grid-area: "submit";
}

.titleSearch {
  color: crimson;
}
</style>