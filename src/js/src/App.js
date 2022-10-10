import './theme.scss';
import './App.css';
import {
    BrowserRouter as Router,
    Routes,
    Route,
    Link
} from "react-router-dom";
import {Profile} from './components/Profile/Profile';
import {Messages} from './components/Messages/Messages';
import {Users} from './components/Users/Users';
import {Login} from './components/Login/Login';
import useToken from './useToken';

function App() {

    const {token, setToken} = useToken();

    if (!token) {
        return <Login setToken={setToken}/>
    }

    return (
        <div className="container">
            <Router>
                <nav className="navbar navbar-expand-lg">
                    <ul className="navbar-nav me-auto mb-2 mb-lg-0">
                        <li className="nav-item">
                            <Link className="nav-link" to="/">Профиль</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/users">Пользователи</Link>
                        </li>
                        <li className="nav-item">
                            <Link className="nav-link" to="/messages">Сообщения</Link>
                        </li>
                    </ul>
                </nav>
                <Routes>
                    <Route path="/" element={<Profile/>}/>
                    <Route path="/profile" element={<Profile/>}/>
                    <Route path="/users" element={<Users/>}/>
                    <Route path="/messages" element={<Messages/>}/>
                </Routes>
            </Router>
        </div>
    );
}

export default App;
