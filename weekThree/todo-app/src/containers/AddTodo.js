import React from 'react'

const AddTodo = () => {
let input;

const handleSubmit =(e)=>{
    e.preventDefault()
    if(!input.value.trim()){
        return
    }
    input.value = ''
}


    return (
        <div>
           <form onSubmit={handleSubmit}>
             <input ref={node => input = node} />
             <button type="submit">
             Add Todo
             </button>
           </form> 
        </div>
    )
}

export default AddTodo
