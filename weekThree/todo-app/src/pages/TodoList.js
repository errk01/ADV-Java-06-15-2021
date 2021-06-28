import React from 'react'
import Todo from './Todo'
const TodoList = ({todos, toggleTodo}) => {
    return (
        <ul>
            {todos && todos.length 
                ? todos.map(todo =>{
                 return <Todo
                  key={todo.id}
                   todo={todo}
                  />
                }): null}
        </ul>
    )
}

export default TodoList
