import { useState, useEffect } from 'react'
import TaskList from './components/TaskList'
import './App.css'
import AddTask from './components/AddTask'

function App() {
  const [tasks, setTasks] = useState([]);
  useEffect(() => {
 
    fetch("http://localhost:8080/api/v1/tasks/all").then((res) => {
        console.log("Status:", res.status);
        return res.json();
    })
    .then((data) => {
        console.log("Data:", data);
        console.log("Is Array:", Array.isArray(data));
        setTasks(data);
    })
    .catch((e) => console.log(e));
  }, []);

  return (
    <>
      <TaskList tasks={ tasks } setTasks= { setTasks } />
      <AddTask setTasks={setTasks} />
    </>
  )
}

export default App
