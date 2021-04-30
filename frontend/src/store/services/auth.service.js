import axios from 'axios';

const API_URL = 'http://localhost:8080/auth/';

class AuthService {
    registration(user) {
        console.log(user)
        const formData = new FormData()
        formData.append("firstName", user.firstName)
        formData.append("secondName", user.secondName)
        formData.append("email", user.email)
        formData.append("password", user.password)
        axios({
            method: "post",
            url: API_URL + 'registration',
            data: formData,
            headers: {
                "Access-Control-Allow-Origin": "*",
            },
        })
            .then(function (response) {
                console.log(response)
            })
            .catch(function (error) {
                console.log(error)
            })
    }
    login(user) {
        const formData = new FormData()
        formData.append("email", user.email)
        formData.append("passowrd", user.password)

        axios({
            method: "post",
            url: API_URL + this.login,
            data: formData,
            headers: {
                "Access-Control-Allow-Origin": "*"
            },
        })
            .then(function (response) {
                console.log(response)
            })
            .catch(function (error) {
                console.log(error)
            })
    }
}

export default new AuthService()