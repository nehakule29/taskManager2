import React, { useState } from 'react'
function TaskList({tasks,setTasks}) {
  const [editingid,setEditingId] = useState(null);
  const [updatedtitle,setUpdatedtitle]=useState("");
  const saveTask = async (e, task)=>{
    e.preventDefault();
    console.log("Save clicked")
     const newtask = {
        title : updatedtitle ,
        completed : task.completed
    } 
    const response = await fetch(`http://localhost:8080/api/v1/tasks/update/${editingid}`,{method:'PUT',headers:{"Content-Type":"application/json"},body:JSON.stringify(newtask)});
    if (!response.ok) {
    throw new Error("Update failed");
    }

    console.log(response);
    const data = await response.json();
    console.log("Updated task");
    setTasks((previousTasks)=>previousTasks.map((task)=>{return task.id===data.id ?  data :task}));
    console.log("Returned from Spring:", data);
    console.log("Current tasks:", tasks);
    setEditingId(null);
    setUpdatedtitle('');
  }
   
  return (
    <>
      <h1>Tasker App</h1>
      <ul>
        {tasks.map((task) => (
          <li key={task.id}>
            {task.id === editingid ? (
              <form>
              <input type='text' value={updatedtitle} onChange={(e)=>setUpdatedtitle(e.target.value)}></input>
              <button type = "button" onClick={(e)=>saveTask(e, task)}>Save</button>
              
              </form>
            ) : (
              <>
                 <h3>{task.title}</h3>
                 <button onClick={(e)=> {setEditingId(task.id);
                   setUpdatedtitle(task.title);
                  } }>Edit</button>

              </>
            )}
          </li>
        ))}
      </ul>
    </>
  )
}
export default TaskList 