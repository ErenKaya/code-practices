import { ADD_TODO } from '../actions/todos.actions'

let initialState = []

export default (state = initialState, action) => {
  switch(action.type) {
    case ADD_TODO:
      return [ ...state, action.payload ]
    default:
      return state
  }
}