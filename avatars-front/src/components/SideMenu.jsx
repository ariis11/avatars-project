import logo from '../assets/logo.png';
import home from '../assets/home.png';
import SideMenuItem from './SideMenuItem';

export default function SideMenu({ setActiveTab, activeTab }) {
    return (
        <div className="side-menu">
            <div className="logo">
                <img src={logo} />
                <p>AIgent</p>
            </div>
            <div className="menu-items">
                <SideMenuItem setActiveTab={setActiveTab} title='Home' image={home} activeTab={activeTab} />
                <SideMenuItem setActiveTab={setActiveTab} title='Create Agent' image={home} activeTab={activeTab} />
                <SideMenuItem setActiveTab={setActiveTab} title='Event Hosts' image={home} activeTab={activeTab} />
                <SideMenuItem setActiveTab={setActiveTab} title='Influencers' image={home} activeTab={activeTab} />
            </div>
        </div>
    );
}