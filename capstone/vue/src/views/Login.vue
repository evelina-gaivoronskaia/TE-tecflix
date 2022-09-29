<template>
  <div id="login" class="text-center">
    <h1 class="logo">Tecflix</h1>
    <div id="about">
      <span>
        We will give you movie suggestions base
        on your favorite movies!</span
      >
    </div>
    <form class="form-signin" @submit.prevent="login">
      <h1 class="sign">Please Sign In</h1>
      <div class="alert alert-danger" role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >
        Thank you for registering, please sign in.
      </div>
      <ul>
        <li>
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
        </li>
        <li>
          <label for="password" class="sr-only">Password</label>
          <input
            type="password"
            id="password"
            class="form-control"
            placeholder="Password"
            v-model="user.password"
            required
          />
        </li>
      <li>
      
      <router-link style="color: orange" :to="{ name: 'register' }"
        >Need an account?</router-link
      >
      </li>
      </ul>
      <button type="submit">Sign in</button>
    </form>
    <link
      href="https://fonts.googleapis.com/css?family=Abel"
      rel="stylesheet"
    />
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
        password: "",
      },
      invalidCredentials: false,
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then((response) => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch((error) => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
  },
};
</script>
<style  scoped>




h1.logo {
  font-size: 100px;
  letter-spacing: 3px;
  text-transform: uppercase;
  font-family: "Abel", "Brushstroke", "Haettenschweiler", "Arial Narrow Bold",
    sans-serif;
  text-align: center;

  background: -webkit-linear-gradient(rgb(250, 146, 49), rgb(232, 236, 252));
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
}
.sign {
  height: 0px;
  width: 100%;
  font-size: 18px;
  text-align: center;
  color: #f24700;
  line-height: 20%;
  border-radius: 1em;
  box-shadow: 0 2px 5px 1px rgba(0, 0, 0, 0.2);
  font-family: "Abel";
  font-size: 30px;
   border: 2px inset #9090a5; 
  border-style:outset;
  border-radius: 1em; 
  border-color: #e6e6f1;
  /* border-radius: 3px 3px 0 0; */

  /* border-width: 3px;
  border-top: solid;
  border-bottom: solid;
  margin-bottom: 55px;
  border-color: #010130; */
}
form{
 margin: 0 auto;
  width: 450px;
  height: 350px;
  background-color: #010130;
  padding: 2em;
   border: 2px inset #9090a5; 
  border-style:outset;
  border-radius: 1em; 
  border-color: #e6e6f1; 
  align-items: center;
  
}

.sign {
  box-sizing: border-box;
  padding: 50px;
}

/* margin: 0 auto;
  width: 100%;
  max-width: 500px;
 text-align: center;
 padding: 10px ;
 border-style: none;
 /* border-width:3px;
 border-style: groove;
 /* border-right: solid;
 border-left: solid ; *
border-color: #f2f2fc;
 padding: 80px;
 margin-top: .5em;
background-color:rgba(10, 2, 48, 0.5) */

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

#about {
  font-family: "Time", "Lucida Sans Regular", "Lucida Grande",
    "Lucida Sans Unicode", Geneva, Verdana, sans-serif;
  color: rgb(253, 250, 246);
  text-align: center;
  border-style: none;
  margin-bottom: 60px;
  
}



span {
  background-color: rgba(10, 2, 48, 0.1);
}




input[type="text"] {
  padding: 4px;
  border: 0;
  box-shadow: 0 0 15px 2px #ff6626; 
}
input[type="password"] {
  padding: 4px;
  border: 0;
  box-shadow: 0 0 15px 2px #ff6626;
}
input:hover {
  background: rgb(240, 172, 83);
}
/* button {
border: none;
background: #f24700;
cursor:pointer;
border-radius:3px;
padding: 6px;
width: 200px;
color: white;
margin-left: 25px;
box-shadow: 0 3px 6px 0 rgba(0,0,0,0.2);
 
  } */
button {
  width: 60%;
  height: 40px;
  margin: 10px auto;
  justify-content: center;
  display: block;
  color: #fff;
  background: #f24700;
  font-size: 1em;
  font-weight: bold;
  margin-top: 20px;
  outline: none;
  border: none;
  border-radius: 5px;
  transition: 0.2s ease-in;
  cursor: pointer;
}
button:hover {
  background: rgb(240, 172, 83);
}

button:hover {
  transform: translateY(-3px);
  box-shadow: 0 6px 6px 0 rgba(0, 0, 0, 0.2);
}

.logo {
  font-size: 5rcm;
}
</style>
