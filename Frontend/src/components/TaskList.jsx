import React, { useState } from 'react'

function TaskList({ tasks }) {
  const [editable,iseditable]=useState(false);
    console.log(tasks)
  return (
    <>
      <h1>Tasker App</h1>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <h3>{task.title}</h3>
            <input type='checkbox' checked={task.completed?true:false}></input>
            <button id={task.id} value={editable}>Edit</button>
            <EditTask task={task}/>
          </li>

        ))}


      </ul>
    </>
  )
}

export default TaskList