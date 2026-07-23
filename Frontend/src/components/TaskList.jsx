import React from 'react'

function TaskList({ tasks }) {
    console.log(tasks)
  return (
    <>
      <h1>Tasker App</h1>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            <h3>{task.title}</h3>
            <p>Completed: {task.completed ? 'Yes' : 'No'}</p>
          </li>
        ))}
      </ul>
    </>
  )
}

export default TaskList