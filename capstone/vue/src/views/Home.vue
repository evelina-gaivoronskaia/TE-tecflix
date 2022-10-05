<template>
  <div class="home">
    <h1 class="header">HOME</h1>
    <router-link class="link" :to="{ name: 'createProfile' }"
      >CREATE PROFILE</router-link
    >
    <router-link class="link" :to="{ name: 'browseMovies' }">
      See All Movies
    </router-link>
    <router-link class="link" :to="{ name: 'favoriteMovieCard' }">
      See Favorite Movies
    </router-link>
  </div>
</template>

<script>
export default {
  name: "home",
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Monoton&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");

.home {
  display: block;
  width: 50%;
  min-height: 500px;
  padding: 20px;
  border: 5px solid #010130;
  background-color: #010130;
  margin: 0;
  text-align: center;
  position: relative;
  top: 50%;
  transform: translateY(20%);
  left: 25%;
  right: 25%;
  color: #ff6626;
}
.header {
  font-size: 150px;
  font-family: "Monoton", sans-serif;
  font-weight: 400;
  margin: 5%;
  overflow-wrap: break-word;
  text-size-adjust: auto;
}
.link {
  display: block;
  color: #e88b65;
  font-size: 50px;
  font-family: "Bebas Neue", sans-serif;
  margin: 5%;
}
</style>
