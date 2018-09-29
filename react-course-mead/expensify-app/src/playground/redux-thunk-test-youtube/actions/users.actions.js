import axios from "axios";
export const FETCH_USERS = 'fetch-users';


export const getAllUsers = () => {
    console.log("get all user");
    return (dispatch) => {
        axios({
            method: 'get',
            url: 'https://jsonplaceholder.typicode.com/users',
        }).then((users) => {
            let data = users.data;
            dispatch({ type: FETCH_USERS, payload: data })
        }).catch((err) => {
            console.log(err);
        })
    }
}