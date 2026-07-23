import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import './index.css'
import TaskList from './components/TaskList'
import App from './App'
createRoot(document.getElementById('root')).render(
  <App/>
)
