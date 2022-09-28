<template>
  <div id="login" class="text-center">
    <h1 class="logo">Tecflix</h1>
    <div id="about"><span> Welcome to the Movie Suggestor we will give you movie suggestions
      base on your favorite movies!</span> </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="sign">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <router-link style=" color: orange;" :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
    </form>
    <link href='https://fonts.googleapis.com/css?family=Abel' rel='stylesheet'>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>
<style  scoped>
h1.logo{
font-size: 100px;
letter-spacing:3px ;
text-transform: uppercase;
font-family: 'Abel' ,'Brushstroke', 'Haettenschweiler', 'Arial Narrow Bold', sans-serif;
text-align: center;

background: -webkit-linear-gradient(rgb(250, 146, 49), rgb(232, 236, 252));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  

}
.sign{
  font-family:'Abel';
  color: rgb(0, 4, 7);
  background-color:#ff6626;
  border-width: 3px;
  border-top: solid;
  border-bottom: solid;
  margin-bottom: 55px;
  border-color: #010130;
  
}


.form-signin{
margin:0 auto;
  width: 100%;
  max-width: 500px;
 text-align: center;
 padding: 10px ;
 border-width:3px;
 border-style: groove;
 /* border-right: solid;
 border-left: solid ; */
border-color: #f2f2fc;
 padding: 80px;
 margin-top: .5em;
background-color: #010130 
 
 /* margin-top: 400px;
 margin-left: ;
 margin-right: auto; */
 /* min-height: 10cm;
 display: table-cell;
 vertical-align: middle;
 margin-left: auto;
 margin-right: auto;
width: 50%;
text-align: center; */
}
#about{
font-family: 'Time', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
color: rgb(253, 250, 246);
text-align: center;
border-style: none;
 

}

span{
  background-color:rgba(10, 2, 48, 0.9);
}
input[type=text] {
  padding:2px;
  border:0;
  box-shadow:0 0 15px 4px #ff6626;
  
}
input[type=password] {
  padding:2px;
  border:0;
  box-shadow:0 0 15px 4px #ff6626;
  
}
input:hover{
  background:rgb(240, 172, 83);
}
button{
  display:inline-block;
padding:0.25em 1.2em;
border:0.1em solid #FFFFFF;
margin:0 0.3em 0.3em 0;
border-radius:0.12em;
box-sizing: border-box;
text-decoration:none;
font-family:'Georgia',sans-serif;
font-weight:300;
color:#06053b;
text-align:center;
transition: all 0.2s;
}
button:hover{
  color: #b95d07;
}


.logo{
  font-size: 5rcm;
}

</style>
