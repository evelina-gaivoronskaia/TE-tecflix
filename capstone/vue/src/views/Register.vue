<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <h1 id="header" class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div
        id="error"
        class="alert alert-danger"
        role="alert"
        v-if="registrationErrors"
      >
        {{ registrationErrorMsg }}
      </div>
      <label id="usernameLabel" for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />

      <label id="passwordLabel" for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link id="link" :to="{ name: 'login' }"
        >Have an account?</router-link
      >
      <button
        id="createAccount"
        class="btn btn-lg btn-primary btn-block"
        type="submit"
      >
        Create Account
      </button>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "register",
  data() {
    return {
      user: {
        username: "",
        password: "",
        confirmPassword: "",
        role: "user",
      },
      registrationErrors: false,
      registrationErrorMsg: "There were problems registering this user.",
    };
  },
  methods: {
    register() {
      var count = 0;
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = "Password & Confirm Password do not match.";
      } else {
        var i = 0;
        var character = "";
        while (i < this.user.password.length) {
          character = this.user.password.charAt(i);
          if (character == character.toUpperCase()) {
            count++;
          }
          i++;
        }
        if (count > 0 && this.user.password.length >= 8) {
          authService
            .register(this.user)
            .then((response) => {
              if (response.status == 201) {
                this.$router.push({
                  path: "/login",
                  query: { registration: "success" },
                });
              }
            })
            .catch((error) => {
              const response = error.response;
              this.registrationErrors = true;
              if (response.status === 400) {
                this.registrationErrorMsg = "Bad Request: Validation Errors";
              }
            });
        } else {
          this.registrationErrors = true;
          this.registrationErrorMsg =
            "Password MUST contain at least 8 characters and at least one Uppercase letter!";
        }
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = "There were problems registering this user.";
    },
  },

  // computed: {
  //   passwordValidation() {
  //     let errors = [];
  //     for (let condition of this.rules) {
  //       if (!condition.regex.test(this.password)) {
  //         errors.push(condition.message);
  //       }
  //     }
  //     if (errors.length === 0) {
  //       return { valid: true, errors };
  //     } else {
  //       return { valid: false, errors };
  //     }
  //   },
  // },
};
</script>

<style scoped>
@import url("https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Monoton&display=swap");

form {
  display: grid;
  grid-template-areas: 1fr 1fr;
  grid-template-areas:
    "header header"
    "usernameLabel username"
    "passwordLabel password"
    "passwordLabel confirmPassword"
    ". ."
    "link link"
    "error error"
    "createAccount createAccount";
  gap: 20px;
}

#header {
  grid-area: header;
  color: #ff6626;
  font-family: "Bebas Neue", sans-serif;
  font-size: 50px;
}

#usernameLabel {
  grid-area: usernameLabel;
  display: flex;
  align-items: center;
  justify-content: center;
  font-family: "Bebas Neue", sans-serif;
  font-size: 25px;
}

#username {
  grid-area: username;
  font-family: "Bebas Neue", sans-serif;
}

#passwordLabel {
  grid-area: passwordLabel;
  display: flex;
  align-items: center;
  justify-content: center;
  font-family: "Bebas Neue", sans-serif;
  font-size: 25px;
}

#password {
  grid-area: password;
  font-family: "Bebas Neue", sans-serif;
}

#confirmPassword {
  grid-area: confirmPassword;
  font-family: "Bebas Neue", sans-serif;
}

#link {
  grid-area: link;
  font-family: "Bebas Neue", sans-serif;
  font-size: 25px;
}

#error {
  grid-area: error;
  color: #ff5e0e;
  font-family: "Bebas Neue", sans-serif;
  font-size: 25px;
}

#createAccount {
  grid-area: createAccount;
  font-family: "Bebas Neue", sans-serif;
  font-size: 20px;
  margin: 0px 50px 0px 50px;
}

.form-register {
  margin: 0 auto;
  width: 100%;
  max-width: 500px;
  text-align: center;
  align-content: center;
  border-width: 3px;
  /* border-style: groove;
  border-color: #f2f2fc; */
  border-radius: 9px;
  padding: 80px;
  margin-top: 10em;
  background-color: #010130;
}

#password,
#confirmPassword,
#username {
  padding: 2px;
  margin: 5px 5px 5px 5px;
  border: 0;
  box-shadow: 0 0 15px 4px #ff6626;
  text-align: center;
  align-content: center;
}

#link {
  color: rgb(240, 172, 83);
}

/* #createAccount {
  display: block;
} */
</style>
