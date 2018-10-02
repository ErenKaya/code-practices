import React, { Component } from 'react'
import { connect } from 'react-redux'
import { bindActionCreators } from 'redux'
import { getAllUsers } from './actions/users.actions'

class App extends Component {

  componentDidMount() {
    this.props.getAllUsers()
  }

  handleSubmit = (event) => {
    event.preventDefault()
    this.props.addNewTodo(this.state.newTodo)
  }

  render() {
    let todosList = this.props.todos
      .map((todo, i) => {
        return ( 
          <li key={i}>{todo}</li> 
        )
      })
    let usersList = this.props.users.map(user => 
      <li key={user.id}>{user.name}</li>)
    return (
      <div className="App">

        <h2>List of todos</h2>
        <ul>{todosList}</ul>
        <h2>List of users</h2>
        <ul>{usersList}</ul>
      </div>
    );
  }
}

function mapStateToProps(state) {
  return {
    todos: state.todos,
    users: state.users
  }
}

function mapDispatchToProps(dispatch) {
  return {
    getAllUsers: bindActionCreators(getAllUsers, dispatch)
  }
}

export default connect(mapStateToProps, mapDispatchToProps)(App);
