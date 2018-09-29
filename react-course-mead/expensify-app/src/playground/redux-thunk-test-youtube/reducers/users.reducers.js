import { FETCH_USERS } from '../actions/users.actions'

let initialState = []

export default (state = initialState, action) => {
    console.log(action.type);
  switch(action.type) {
    case FETCH_USERS:
      return [...state, ...action.payload]
    default:
      return state
  }
}