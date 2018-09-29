import users from './users.reducers'
import todos from './todos.reducers'
import { combineReducers } from 'redux'
console.log("selam1")
const rootReducer = combineReducers({
  todos,
  users
})

export default rootReducer