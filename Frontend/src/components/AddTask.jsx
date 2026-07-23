import React, { useContext, useState } from 'react';

function AddTask({setTasks}) {
    console.log("AddTask rendered");
    const [title,settitle] = useState('');
    const [completed,isCompleted] = useState(false);
    
    function updateTitle(value){
        settitle(value);
    }
    function updateCompleted(value){
        isCompleted(value);
    }
    async function updateTasks(){
        console.log("updateTasks called");
        const task = {
        title,
        completed
    } 
    try{
        console.log(JSON.stringify(task));
       const res = await fetch("http://localhost:8080/api/v1/tasks/create",{method:"POST",headers:{"Content-Type":"application/json"},body:JSON.stringify(task)});
       const data = await res.json();
       if (!res.ok) {
        console.log("Error:", data);
    // handle the error
}
       console.log("Returned from Spring:", data);
       setTasks((prev)=>[...prev,data]);
       console.log(data);
       settitle('');
       isCompleted(false);
    }catch(e){
        console.log(e);
    } 
    }
  
    return(
        <>
        <input type="text" value={title} onChange={(e)=>{updateTitle(e.target.value)}} placeholder='Enter Title'/>
        <input type="checkbox" checked={completed} onChange={(e)=>{updateCompleted(e.target.checked)}}/>
        <button onClick={(e)=>{e.preventDefault(); updateTasks()}}>Add Task</button>
        </>
        
    )
}

export default AddTask;