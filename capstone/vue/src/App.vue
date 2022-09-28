<template>
  <div id="app">
    <div id="nav">
      <router-link id="home" v-bind:to="{ name: 'home' }">Home</router-link
      >&nbsp;|&nbsp;
      <router-link
        id="logout"
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >
    </div>
    <router-view />
  </div>
</template>
<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");
#nav {
  display: block;
  width: 10%;
  text-align: center;
  background-color: #010130;
  max-height: 70px;
  padding: 5px;
}
#home,
#logout,
#nav {
  margin: 5px;
  color: #e88b65;
  font-family: "Bebas Neue", sans-serif;
}
</style>
